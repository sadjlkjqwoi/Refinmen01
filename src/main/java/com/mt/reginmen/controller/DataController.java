package com.mt.reginmen.controller;

import com.mt.reginmen.domain.Data;
import com.mt.reginmen.domain.Label;
import com.mt.reginmen.domain.Reviews_data;
import com.mt.reginmen.service.DataService;
import com.mt.reginmen.service.RegisterService;
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
     * 上传该条数据的所有的评论
     */
    @GetMapping("/findAllReviews")
    List<Reviews_data> findAllReviews(String ids) {
        List<Reviews_data> reviews_data = new ArrayList<>();
        String[] id = ids.split(",");
        for (int i = 0; i < id.length; i++) {
            Reviews_data reviews_data1 = dataService.findReviewsById(Integer.parseInt(id[i]));
            reviews_data.add(reviews_data1);
        }
        return reviews_data;
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
     * 根据热度推荐所有数据
     *
     * @return
     */
    @GetMapping("/findDataByCount")
    List<Data> findDataByCount() {
        List<Data> datas = dataService.findDataByCount();

        return datas;
    }

    /**
     * 点击量添加
     */
    @PutMapping("/click")
    public void click(int id) {
        dataService.click(id);
    }

    @GetMapping("/getLabelHot")
    public Map<Integer,Double> getLabelHot(int min, int max){
        return dataService.getLabelHot(min, max);
    }




}
