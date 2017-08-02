package com.wonhwee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wonhwee.model.Activity;
import com.wonhwee.model.Exercise;
import com.wonhwee.repository.ExerciseRepository;

@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService {
  
  @Autowired
  private ExerciseRepository exerciseRepository;

  @Override
  public List<Activity> findAllActivities() {
    List<Activity> activities = new ArrayList<Activity>();
    
    Activity run = new Activity();
    run.setDesc("Run");
    
    Activity bike = new Activity();
    bike.setDesc("Bike");
    
    Activity swim = new Activity();
    swim.setDesc("Swim");
    
    activities.add(run);
    activities.add(bike);
    activities.add(swim);
    
    return activities;
  }

  @Override
  public Exercise save(Exercise exercise) {
    exercise = exerciseRepository.save(exercise);
    return exercise;
  }

}
