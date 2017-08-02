package com.wonhwee.service;

import java.util.List;

import com.wonhwee.model.Goal;
import com.wonhwee.model.GoalReport;

public interface GoalService {
  Goal save(Goal goal);
  List<Goal> findAllGoals();
  List<GoalReport> findAllGoalReports();
}
