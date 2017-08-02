package com.wonhwee.service;

import java.util.List;

import com.wonhwee.model.Activity;
import com.wonhwee.model.Exercise;

public interface ExerciseService {
  List<Activity> findAllActivities();
  Exercise save(Exercise exercise);
}
