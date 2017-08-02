package com.wonhwee.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wonhwee.model.Activity;
import com.wonhwee.model.Exercise;
import com.wonhwee.model.Goal;
import com.wonhwee.service.ExerciseService;

@Controller
public class MinutesController {

  private static final Logger logger = LoggerFactory.getLogger(MinutesController.class);
  
  @Autowired
  private ExerciseService exerciseService;
  
  @RequestMapping(value="/addMinutes", method=RequestMethod.GET)
  public String addMinutes(@ModelAttribute ("exercise") Exercise exercise) {
    return "addMinutes";
  }
  
  @RequestMapping(value="/addMinutes", method=RequestMethod.POST)
  public String addMinutes(@Valid @ModelAttribute("exercise") Exercise exercise, HttpSession session, BindingResult result){
    logger.info("exercise:" + exercise.getMinutes());
    logger.info("exercise activity:" + exercise.getActivity());

    if(result.hasErrors()){
      return "addMinutes";
    }
    else{
      Goal goal = (Goal)session.getAttribute("goal");
      
      exercise.setGoal(goal);
      exerciseService.save(exercise);
    }
    
    return "addMinutes";
  }
  
  @RequestMapping(value="/activities", method=RequestMethod.GET)
  public @ResponseBody List<Activity> findAllActivities() {
    return exerciseService.findAllActivities();
  }
  
  @RequestMapping(value="{id}/activities", method=RequestMethod.GET)
  public @ResponseBody List<Activity> findActivities(@PathVariable long id) {
    logger.info("id:" + id);
    return exerciseService.findAllActivities();
  }
  
}
