package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    //test the equals method
    @Test
    public void equals_returns_true_for_equal_teams() {
        Team team2 = new Team("test-team");
        Team team1 = new Team("test-team");
        assertEquals(team1, team2, "same team not equal");
    }
    @Test
    public void equals_returns_true_for_same_teams() {
        Team team2 = new Team("test-team");
        assertEquals(team2, team2, "same team not equal");
    }
    //test the equals method for different teams with same name and members
    @Test
    public void equals_returns_true_for_different_teams_with_same_name_and_members() {
        Team team2 = new Team("test-team");
        team2.addMember("test-member");
        Team team = new Team("test-team");
        team.addMember("test-member");
        assertEquals(team, team2, "teams with same name and members should not be equal");
    }

    //test the equals method for teams with different members, same name
    @Test
    public void equals_returns_false_for_different_teams_with_same_name() {
        Team team2 = new Team("test-team");
        team2.addMember("test-member");
        Team team1 = new Team("test-team");
        team1.addMember("test-member1");
        boolean isEqual = team1.equals(team2);
        assertEquals(isEqual, false, "teams with different members should not be equal");
    }
    //test the equals method for different team name with same members
    @Test
    public void equals_returns_false_for_different_teams_with_same_members() {
        Team team2 = new Team("test-team");
        team2.addMember("test-member");

        Team team1 = new Team("test-team1");
        team2.addMember("test-member");
        boolean isEqual = team1.equals(team2);
        assertEquals(isEqual, false, "teams with different names should not be equal");
    }
    
    //test the equals method for different team name with different members
    @Test
    public void equals_returns_false_for_different_teams_with_diff_members() {
        Team team2 = new Team("test-team");
        team2.addMember("test-member");

        Team team1 = new Team("test-team1");
        team2.addMember("test-member1");
        boolean isEqual = team1.equals(team2);
        assertEquals(isEqual, false, "teams with different names and different members should not be equal");
    }

    //test the equals method for different object
    @Test
    public void equals_returns_false_for_different_object() {
        String str = "test-string";
        boolean isEqual = team.equals(str);
        assertEquals(isEqual, false, "team should not be equal to string");
    }
    //test the equals method for null
    @Test
    public void equals_returns_false_for_null() {
        boolean isEqual = team.equals(null);
        assertEquals(isEqual, false, "team should not be equal to null");
    }

    //tests that checks hashcode
    @Test
    public void hashCode_returns_same_hashcode_for_equal_teams() {
        Team team2 = new Team("test-team");
        Team team1 = new Team("test-team");
        assertEquals(team1.hashCode(), team2.hashCode(), "same team not equal");
    }
    @Test
    public void hashCode_returns_same_hashcode_for_same_teams() {
        Team team2 = new Team("test-team");
        assertEquals(team2.hashCode(), team2.hashCode(), "same team not equal");
    }
    //test the hashcode method for different teams with same name and members
    @Test
    public void hashCode_returns_diff_hashcode_for_diff_team_names() {
        Team team2 = new Team("test-team");
        Team team1 = new Team("test-team1");
        boolean isEqual = (team1.hashCode())==(team2.hashCode());
        assertEquals(isEqual, false, "teams with different names should not be equal");
    }
    @Test
    public void hashCode_returns_diff_hashcode_for_diff_team_members() {
        Team team2 = new Team("test-team");
        team2.addMember("test-member");
        Team team1 = new Team("test-team");
        boolean isEqual = (team1.hashCode())==(team2.hashCode());
        assertEquals(isEqual, false, "teams with different members should not be equal");
    }
    @Test
    public void hashCode_returns_diff_hashcode_for_diff_team_members2() {
        Team team2 = new Team("test-team");
        team2.addMember("test-member1");
        Team team1 = new Team("test-team");
        team1.addMember("test-member2");
        boolean isEqual = (team1.hashCode())==(team2.hashCode());
        assertEquals(isEqual, false, "teams with different members should not be equal");
    }
    @Test
    public void hashCode_returns_diff_hashcode_for_diff_team_names_same_members() {
        Team team2 = new Team("test-team1");
        team2.addMember("test-1");
        Team team1 = new Team("test-team2");
        team1.addMember("test-1");
        boolean isEqual = (team1.hashCode())==(team2.hashCode());
        assertEquals(isEqual, false, "teams with different members should not be equal");
    }
}
