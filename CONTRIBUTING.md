# Project Board
> Please move your ticket to the appropriate catagory whenever creating, updating or completing a task.
https://github.com/users/WinteryFox/projects/1

| Column      | Purpose | *Note* | 
| ----------- | ----------- | ----------- |
| Backlog | **Upcoming Sprint Tickets** | *Remember to convert newly created tasks to issues through the GitHub interface.* |
| Open | **Current ToDo Sprint Tickets** | *Remember to convert newly created tasks to issues through the GitHub interface.* |
| In Progress | **In Development Tickets** (with separate branch) | *Remember to create a merge request and associate it with the branch and ticket.* |
| In Review | **In Review Tickets** (with another user than the developer reviewing it) | *Remember to approve the merge requests.* |
| To Test | **Approved Tickets** (from review) That **Still Need Testing** (following test plan) | ~~placeholder~~ |
| In Testing | **In Testing Tickets** | ~~placeholder~~ |
| To Integrate | **Reviewed and Tested Tickets**, Ready for Merge | *Merge the branche through the merge request if pipelines succeed.* |
| Done | **Completed Sprint Tickets** | *Don't forget to move merged branches here when done.* |

# Branches
> Branches and the merge requests will go from US --> FEATURE --> MASTER

> New branches should be **derived from MASTER if it is an entirely new feature**, and **from FEATURE if it is an entirely new User Story** (thus a task/issue on the board). Additionally, TPs can be made to split up larger *User Stories* into sub-tasks. TPs are purely for yourself and do not need reviews when merging into the parent *User Story* branch.

| Branch Name      | Role | Example Branch Name 
| ----------- | ----------- | ----------- |
| master | **Main Branch** | *master* |
| FEATURE_{{custom_feature_branch_name}} | **Feature Branch** | *FEATURE_WebUserInterface* |
| US{{issue_number}}_{{issue_title_name}} | **User Story Branch** | *US13_SliderToManipulateFHR* |
| TP{{parent_us_issue_number}}_{{custom_task_name}} | **Task Branch** | *TP13_GenericSliderComponent* |
