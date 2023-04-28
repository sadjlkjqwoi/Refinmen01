package com.mt.reginmen.controller;

import com.mt.reginmen.domain.Data;
import com.mt.reginmen.domain.Label;
import com.mt.reginmen.domain.Reviews_data;
import com.mt.reginmen.service.DataService;
import com.mt.reginmen.service.RegisterService;
import jdk.jfr.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping
@RestController
public class DataController {
    @Autowired
    private DataService dataService;
    @Autowired
    private RegisterService registerService;


    /**
     * 游客身份
     * 查询所有的数据
     * @return
     */
    @GetMapping("/findAllData")
    public List<Data> findAllData(){
        return dataService.findAllData();
    }

    /**
     * 资源上传
     *根据用户的id来查询所有数据
     * @param id
     * @return
     */
    @GetMapping("/findAllDatas")
    public List<Data> findAllDatas(String id) {
        //用户个性化标签
        String labels = dataService.getUserLabel(id);
        String[] labels_ids = labels.split(",");
        List<Data> datas = new ArrayList<>();
        //获取所有数据
        List<Data> allData = dataService.findAllDatas();
        Boolean[] results = new Boolean[allData.size()];
        for (int i = 0; i < allData.size(); i++) {
            results[i] = false;
        }
        //个性化推荐
        for (int i = 0; i < labels_ids.length; i++) {
            for (int j = 0; j < allData.size(); j++) {
                if (results[j] == false) {
                    String dataLabels = allData.get(j).getLabels_ids();
                    String[] dataLabels_ids = dataLabels.split(",");
                    for (int k = 0; k < dataLabels_ids.length; k++) {
                        if (dataLabels_ids[k].equals(labels_ids[i])) {
                            results[j] = true;
                            datas.add(allData.get(j));
                            break;
                        }
                    }
                }
            }
        }
        return datas;
    }


    /**
     * 根据日期（季节和节气）推荐
     */
    @GetMapping("/findDataByDate")
    List<Data> findDataByDate() {
        List<Data> datas = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        String label = null;
        switch (month) {
            case 3, 4, 5:
                label = "春";
                break;
            case 6, 7, 8:
                label = "夏";
                break;
            case 9, 10, 11:
                label = "秋";
                break;
            case 12, 1, 2:
                label = "冬";
                break;
        }
        List<Label> labels = registerService.showAllLabels();
        int labelId = 0;
        for (int i = 0; i < labels.size(); i++) {
            if (labels.get(i).getName().equals(label)) {
                labelId = labels.get(i).getId();
                break;
            }
        }
        //获取所有数据
        List<Data> allData = dataService.findAllDatas();
        Boolean[] results = new Boolean[allData.size()];
        for (int i = 0; i < allData.size(); i++) {
            results[i] = false;
        }
        for (int j = 0; j < allData.size(); j++) {
            if (results[j] == false) {
                String dataLabels = allData.get(j).getLabels_ids();
                String[] dataLabels_ids = dataLabels.split(",");
                for (int k = 0; k < dataLabels_ids.length; k++) {

                    if (dataLabels_ids[k].equals(String.valueOf(labelId))) {
                        results[j] = true;
                        datas.add(allData.get(j));
                        break;
                    }
                }
            }
        }

        return datas;
    }

    /**
     * 根据年轻人热度标签推荐所有数据
     *
     * @return
     */
    @GetMapping("/findYoung")
    List<Data> findYoung() {
        //年轻人喜欢的label
        List<Integer> young=dataService.getLabelByAge(16,44);
        System.out.println("年轻人的标签："+young);
        List<Data> youngAllDatas=new ArrayList<>();
        List<Data> datas = dataService.findAllData();
        Boolean[] results = new Boolean[datas.size()];
        for (int i = 0; i < datas.size(); i++) {
            results[i] = false;
        }
        for (int i = 0; i <datas.size() ; i++) {
            String dataLabels_ids=datas.get(i).getLabels_ids();
            String []ids=dataLabels_ids.split(",");
                for (int m = 0; m < ids.length; m++) {
                    for (int j = 0; j < young.size(); j++) {
                        if (Integer.parseInt(ids[m])==young.get(j)) {
                            youngAllDatas.add(datas.get(i));
                            results[i]=true;
                            break;
                        }
                    }
                    if (results[i]==true)
                        break;
            }
        }

        return youngAllDatas;
    }

    /**
     * 根据中年人热度标签所有信息
     * @return
     */
    @GetMapping("/findMiddle")
    public List<Data> findMiddle(){
        List<Integer> middleLabel=dataService.getLabelByAge(45,60);
        System.out.println("中年人喜欢的标签："+middleLabel);
        List<Data> middleAllDatas=new ArrayList<>();
        List<Data> datas = dataService.findAllData();
        Boolean[] results = new Boolean[datas.size()];
        for (int i = 0; i < datas.size(); i++) {
            results[i] = false;
        }
        for (int i = 0; i <datas.size() ; i++) {
            String dataLabels_ids=datas.get(i).getLabels_ids();
            String []ids=dataLabels_ids.split(",");
                for (int m = 0; m < ids.length; m++) {
                    for (int j = 0; j < middleLabel.size(); j++) {
                        if (Integer.parseInt(ids[m])==middleLabel.get(j)) {
                            middleAllDatas.add(datas.get(i));
                            results[i]=true;
                            break;
                        }
                    }
                    if (results[i]==true)
                        break;
            }
        }

        return middleAllDatas;
    }

    /**
     * 根据老年人喜欢的标签推荐数据
     * @return
     */
    @GetMapping("/findOld")
    public List<Data> findOld(){
        List<Integer> oldLabel=dataService.getLabelByAge(61,999);
        System.out.println("老年人喜欢的标签："+oldLabel);
        List<Data>  oldAllDatas=new ArrayList<>();
        List<Data> datas = dataService.findAllData();
        Boolean[] results = new Boolean[datas.size()];
        for (int i = 0; i < datas.size(); i++) {
            results[i] = false;
        }
        for (int i = 0; i <datas.size() ; i++) {
            String dataLabels_ids=datas.get(i).getLabels_ids();
            String []ids=dataLabels_ids.split(",");
                for (int m = 0; m < ids.length; m++) {
                    for (int j = 0; j < oldLabel.size(); j++) {
                        if (Integer.parseInt(ids[m])==oldLabel.get(j)) {
                            oldAllDatas.add(datas.get(i));
                            results[i]=true;
                            break;
                        }
                    }
                    if(results[i]==true)
                        break;
            }
        }

        return oldAllDatas;

    }
    /**
     * 点击量添加
     */
    @PutMapping("/click")
    public void click(int id) {
        dataService.click(id);
    }

    @GetMapping("/getLabelHot")
    public List<List<Label>> getLabelHot(){
        return dataService.getLabelTop3();
    }

}
