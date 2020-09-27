package com.tilicho.marketsimplifiedsystemtask.data.remote.models;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PublicRepository {

    @Expose
    @SerializedName("id")
    public long id;

    @Expose
    @SerializedName("node_id")
    public String nodeId;

    @Expose
    @SerializedName("name")
    public String name;

    @Expose
    @SerializedName("full_name")
    public String fullName;

    @Expose
    @SerializedName("private")
    public String isPrivate;

    @Expose
    @SerializedName("owner")
    public Owner owner;

    @Expose
    @SerializedName("html_url")
    public String htmlUrl;

    @Expose
    @SerializedName("description")
    public String description;

    @Expose
    @SerializedName("fork")
    public String fork;

    @Expose
    @SerializedName("url")
    public String url;

    @Expose
    @SerializedName("forks_url")
    public String forksUrl;

    @Expose
    @SerializedName("keys_url")
    public String keysUrl;

    @Expose
    @SerializedName("collaborators_url")
    public String collaboratorsUrl;

    @Expose
    @SerializedName("teams_url")
    public String teamsUrl;

    @Expose
    @SerializedName("hooks_url")
    public String hooksUrl;

    @Expose
    @SerializedName("issue_events_url")
    public String issueEventsUrl;

    @Expose
    @SerializedName("events_url")
    public String eventsUrl;

    @Expose
    @SerializedName("assignees_url")
    public String assigneesUrl;

    @Expose
    @SerializedName("branches_url")
    public String branchesUrl;

    @Expose
    @SerializedName("tags_url")
    public String tagsUrl;

    @Expose
    @SerializedName("blobs_url")
    public String blobsUrl;

    @Expose
    @SerializedName("git_tags_url")
    public String gitTagsUrl;

    @Expose
    @SerializedName("git_refs_url")
    public String gitRefsUrl;

    @Expose
    @SerializedName("trees_url")
    public String treesUrl;

    @Expose
    @SerializedName("statuses_url")
    public String statusesUrl;

    @Expose
    @SerializedName("languages_url")
    public String languagesUrl;

    @Expose
    @SerializedName("stargazers_url")
    public String stargazersUrl;

    @Expose
    @SerializedName("contributors_url")
    public String contributorsUrl;

    @Expose
    @SerializedName("subscribers_url")
    public String subscribersUrl;

    @Expose
    @SerializedName("subscription_url")
    public String subscriptionUrl;

    @Expose
    @SerializedName("commits_url")
    public String commitsUrl;

    @Expose
    @SerializedName("git_commits_url")
    public String gitCommitsUrl;

    @Expose
    @SerializedName("comments_url")
    public String commentsUrl;

    @Expose
    @SerializedName("issue_comment_url")
    public String issueCommentUrl;

    @Expose
    @SerializedName("contents_url")
    public String contentsUrl;

    @Expose
    @SerializedName("compare_url")
    public String compareUrl;

    @Expose
    @SerializedName("merges_url")
    public String mergesUrl;

    @Expose
    @SerializedName("archive_url")
    public String archiveUrl;

    @Expose
    @SerializedName("downloads_url")
    public String downloadsUrl;

    @Expose
    @SerializedName("issues_url")
    public String issuesUrl;

    @Expose
    @SerializedName("pulls_url")
    public String pullsUrl;

    @Expose
    @SerializedName("milestones_url")
    public String milestonesUrl;

    @Expose
    @SerializedName("notifications_url")
    public String notificationsUrl;

    @Expose
    @SerializedName("labels_url")
    public String labelsUrl;

    @Expose
    @SerializedName("releases_url")
    public String releasesUrl;

    @Expose
    @SerializedName("deployments_url")
    public String deploymentsUrl;

    public static DiffUtil.ItemCallback<PublicRepository> DIFF_CALLBACK = new DiffUtil.ItemCallback<PublicRepository>() {
        @Override
        public boolean areItemsTheSame(@NonNull PublicRepository oldItem, @NonNull PublicRepository newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull PublicRepository oldItem, @NonNull PublicRepository newItem) {
            return oldItem.equals(newItem);
        }
    };

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        PublicRepository repo = (PublicRepository) obj;
        return repo.id == this.id;
    }

}
