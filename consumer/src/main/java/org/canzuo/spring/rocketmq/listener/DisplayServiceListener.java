package org.canzuo.spring.rocketmq.listener;import org.canzuo.spring.rocketmq.action.DrawSierpinskiFractal;import org.canzuo.spring.rocketmq.event.DrawSierpinskiEvent;import org.springframework.context.ApplicationListener;import org.springframework.stereotype.Service;import javax.annotation.Resource;@Servicepublic class DisplayServiceListener implements ApplicationListener<DrawSierpinskiEvent> {    @Resource    DrawSierpinskiFractal draw;    @Override    public void onApplicationEvent(DrawSierpinskiEvent event) {        try {            draw.action((Integer) event.getSource());        } catch (Exception e) {            e.printStackTrace();        }    }}