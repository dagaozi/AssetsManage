package com.wyyy.assetsmanage.model;

import java.util.List;

/**
 * Created by haohaibin .（dagaozi@163.com）
 * 创建时间：2016/7/21 8:54
 * 类描述：
 */
public class TaskModel {

    /**
     * task_list : [{"task_id":"sample string 1","task_content":"sample string 2"},{"task_id":"sample string 1","task_content":"sample string 2"}]
     * code : 1
     */


    /**
     * task_id : sample string 1
     * task_content : sample string 2
     */

    private List<TaskListBean> task_list;


    public List<TaskListBean> getTask_list() {
        return task_list;
    }

    public void setTask_list(List<TaskListBean> task_list) {
        this.task_list = task_list;
    }

    public static class TaskListBean {
        private String task_id;
        private String task_content;

        public String getTask_id() {
            return task_id;
        }

        public void setTask_id(String task_id) {
            this.task_id = task_id;
        }

        public String getTask_content() {
            return task_content;
        }

        public void setTask_content(String task_content) {
            this.task_content = task_content;
        }
    }
}
