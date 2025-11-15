package com.Books.web.app.controller.need;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Books.common.result.Result;


@RestController
@RequestMapping("/app/needs")
@Tag(name="我需要")
public class NeedController {

//    @Autowired
//    private

    public Result saveOrUpdate() {
        return null;
    }

    public Result delete() {
        return null;
    }

    public Result getDetailNeedById(){
        return null;
    }

    public Result getNeedListByUserId(){
        return null;
    }

}
