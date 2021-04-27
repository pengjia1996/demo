package com.pj.orm;

import lombok.Data;

/**
 * @author pengjia
 * @version 1.0
 * @date 2021/4/27 15:23
 */
@Data
public class Student {


        //学生编号
        private Integer stuId;
        //学生姓名
        private String stuName;
        //此处省略其它属性……
        public Student(){
            super();
        }
        public Student(Integer stuId,String stuName){
            this.stuId=stuId;
            this.stuName=stuName;
            //省略代码……
        }
        //省略各种get set方法


}
