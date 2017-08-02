package com.wonhwee.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="goals")
public class Goal {
  public static final String FIND_ALL_GOALS = "findAllGoals";
  public static final String FIND_GOAL_REPORTS = "findGoalReports";
  
  @Id
  @GeneratedValue
  @Column(name="GOAL_ID")
  private Long id;
  
  @Range(min=1, max=120)
  @Column(name="MINUTES")
  private int minutes;
  
  @OneToMany(mappedBy="goal", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
  private List<Exercise> exercises = new ArrayList();

  public Long getId() {
    return id;
  }

  public int getMinutes() {
    return minutes;
  }

  public List<Exercise> getExercises() {
    return exercises;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setMinutes(int minutes) {
    this.minutes = minutes;
  }

  public void setExercises(List<Exercise> exercises) {
    this.exercises = exercises;
  }
}
