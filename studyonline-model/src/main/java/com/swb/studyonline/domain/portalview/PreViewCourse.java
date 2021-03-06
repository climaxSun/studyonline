package com.swb.studyonline.domain.portalview;

import com.swb.studyonline.domain.course.CourseBase;
import com.swb.studyonline.domain.course.CourseMarket;
import com.swb.studyonline.domain.course.CoursePic;
import com.swb.studyonline.domain.course.ext.TeachplanNode;
import com.swb.studyonline.domain.report.ReportCourse;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by admin on 2018/2/27.
 */
@Data
@ToString
@Document(collection = "pre_view_course")
public class PreViewCourse implements Serializable{

    @Id
    private String id;
    private CourseBase courseBase;
    private CourseMarket courseMarket;
    private CoursePic coursePic;
    private TeachplanNode teachplan;
    //课程统计信息
    private ReportCourse reportCourse;

}
