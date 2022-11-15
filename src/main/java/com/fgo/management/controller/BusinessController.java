package com.fgo.management.controller;

import com.fgo.management.annotations.LoginValid;
import com.fgo.management.dto.MyResponse;
import com.fgo.management.model.BusinessOrder;
import com.fgo.management.model.ParamConfig;
import com.fgo.management.service.OrderDetailService;
import com.fgo.management.service.ParamConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/business")
@RestController
public class BusinessController {

    @Autowired
    private ParamConfigService paramConfigService;
    @Autowired
    private OrderDetailService orderDetailService;

    @PutMapping("/event/activePower")
    @LoginValid
    public MyResponse setEventActivePower(HttpServletRequest request, @Validated @RequestBody ParamConfig paramConfig) {
        paramConfigService.updateParamValue(paramConfig.getRootParam(), paramConfig.getSubParam(), paramConfig.getParamValue());
        return MyResponse.success();
    }

    @PostMapping("/order")
    @LoginValid
    public MyResponse businessOrder(HttpServletRequest request, @Validated @RequestBody List<BusinessOrder> businessOrders) {
        paramConfigService.setBusinessOrder(businessOrders);
        return MyResponse.success();
    }

    @GetMapping("/progressOverview")
    public MyResponse progress(@RequestParam long orderId) {
        // 订单服务
        return MyResponse.success(orderDetailService.progress(orderId));
    }
}
