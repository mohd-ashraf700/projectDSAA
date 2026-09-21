package main.java.dsaarena.repository;

import main.java.dsaarena.model.Submission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubmissionRepository {
    private Map<Long , Submission> submissions;
    private Map<Long , List<Submission>> matchSubmissions;

    public SubmissionRepository(){
        submissions = new HashMap<>();
        matchSubmissions = new HashMap<>();
    }


    //add submission
    public void addSubmission(Submission submission){
        if(submission == null){
            return;
        }
        submissions.put(submission.getSubmissionId(), submission);
        long matchId = submission.getMatchId();
        if(!matchSubmissions.containsKey(matchId)){
            matchSubmissions.put(matchId , new ArrayList<>());
        }
        matchSubmissions.get(matchId).add(submission);
    }

    // get submission by id
    public Submission getSubmissionById(long submissionId){
        return submissions.get(submissionId);
    }

    //get all submission
    public List<Submission> getAllSubmission(){
        return new ArrayList<>(submissions.values());
    }

    // get submission by match id
    public List<Submission> getSubmissionsByMatchId(long matchId){
        if(!matchSubmissions.containsKey(matchId)){
            return new ArrayList<>();
        }
        return new ArrayList<>(matchSubmissions.get(matchId));
    }

    // remove submissions
    public void removeSubmission(long submissionId){
        Submission submission = submissions.get(submissionId);
        if(submission == null) {
            return;
        }
        long matchId = submission.getMatchId();
        submissions.remove(submissionId);
        List<Submission> submissionList = matchSubmissions.get(matchId);
        submissionList.remove(submission);
        if(submissionList.isEmpty()){
            matchSubmissions.remove(matchId);
        }
    }
}
