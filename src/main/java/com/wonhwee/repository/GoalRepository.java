package com.wonhwee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wonhwee.model.Goal;
import com.wonhwee.model.GoalReport;

@Repository("goalRepository")
public interface GoalRepository extends JpaRepository<Goal, Long> {
  @Query("Select new com.wonhwee.model.GoalReport(g.minutes, e.minutes, e.activity) from Goal g, Exercise e where g.id=e.goal.id")
  List<GoalReport> findAllGoalReports();
}
