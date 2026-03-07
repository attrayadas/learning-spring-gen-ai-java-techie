package com.attraya.controller;

import com.attraya.dto.TripPlan;
import com.attraya.service.TripPlannerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/trips")
public class TripPlannerController {

    private final TripPlannerService tripPlannerService;

    public TripPlannerController(TripPlannerService tripPlannerService) {
        this.tripPlannerService = tripPlannerService;
    }

    @GetMapping("/plan-trip")
    public TripPlan getTripPlanners(@RequestParam String message){
        return tripPlannerService.getTripPlans(message);
    }

    @GetMapping("/trip-spots")
    public List<String> getTripSpots(@RequestParam String message){
        return tripPlannerService.getTripSpots(message);
    }

    @GetMapping("/trip-guide")
    public Map<String, Object> getTripGuide(@RequestParam String message){
        return tripPlannerService.getTripGuide(message);
    }

    @GetMapping("/complete-trip-plan")
    public List<TripPlan> getCompleteTripGuide(@RequestParam String message){
        return tripPlannerService.getCompleteTripPlan(message);
    }

}
