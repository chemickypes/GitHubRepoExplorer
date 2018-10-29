package com.angelomoroni.githubrepoexplorer

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import com.squareup.moshi.Json

data class User(

	@field:Json(name="gists_url")
	val gistsUrl: String? = null,

	@field:Json(name="repos_url")
	val reposUrl: String? = null,

	@field:Json(name="following_url")
	val followingUrl: String? = null,

	@field:Json(name="bio")
	val bio: String? = null,

	@field:Json(name="created_at")
	val createdAt: String? = null,

	@field:Json(name="login")
	val login: String? = null,

	@field:Json(name="type")
	val type: String? = null,

	@field:Json(name="blog")
	val blog: String? = null,

	@field:Json(name="subscriptions_url")
	val subscriptionsUrl: String? = null,

	@field:Json(name="updated_at")
	val updatedAt: String? = null,

	@field:Json(name="site_admin")
	val siteAdmin: Boolean? = null,

	@field:Json(name="company")
	val company: String? = null,

	@field:Json(name="id")
	val id: Int? = null,

	@field:Json(name="public_repos")
	val publicRepos: Int? = null,

	@field:Json(name="gravatar_id")
	val gravatarId: String? = null,

	@field:Json(name="email")
	val email: String? = null,

	@field:Json(name="organizations_url")
	val organizationsUrl: String? = null,

	@field:Json(name="hireable")
	val hireable: Boolean? = null,

	@field:Json(name="starred_url")
	val starredUrl: String? = null,

	@field:Json(name="followers_url")
	val followersUrl: String? = null,

	@field:Json(name="public_gists")
	val publicGists: Int? = null,

	@field:Json(name="url")
	val url: String? = null,

	@field:Json(name="received_events_url")
	val receivedEventsUrl: String? = null,

	@field:Json(name="followers")
	val followers: Int? = null,

	@field:Json(name="avatar_url")
	val avatarUrl: String? = null,

	@field:Json(name="events_url")
	val eventsUrl: String? = null,

	@field:Json(name="html_url")
	val htmlUrl: String? = null,

	@field:Json(name="following")
	val following: Int? = null,

	@field:Json(name="name")
	val name: String? = null,

	@field:Json(name="location")
	val location: String? = null,

	@field:Json(name="node_id")
	val nodeId: String? = null
){
	constructor(user: UserEntity) :  this(
		user.gistsUrl,user.reposUrl,user.followingUrl,user.bio,user.createdAt,user.login,user.type,
		user.blog,user.subscriptionsUrl,user.updatedAt,user.siteAdmin,user.company,user.id,user.publicRepos,
		user.gravatarId,user.email,user.organizationsUrl,user.hireable,user.starredUrl,user.followersUrl,user.publicGists,
		user.url,user.receivedEventsUrl,user.followers,user.avatarUrl,user.eventsUrl,user.htmlUrl,user.following,user.name,
		user.location,user.nodeId
	)
}

@Entity(tableName = "users", indices = [Index("login")])
data class UserEntity(

	@ColumnInfo(name="gists_url")
	var gistsUrl: String? = null,

	@ColumnInfo(name="repos_url")
	var reposUrl: String? = null,

	@ColumnInfo(name="following_url")
	var followingUrl: String? = null,

	@ColumnInfo(name="bio")
	var bio: String? = null,

	@ColumnInfo(name="created_at")
	var createdAt: String? = null,

	@ColumnInfo(name="login")
	var login: String? = null,

	@ColumnInfo(name="type")
	var type: String? = null,

	@ColumnInfo(name="blog")
	var blog: String? = null,

	@ColumnInfo(name="subscriptions_url")
	var subscriptionsUrl: String? = null,

	@ColumnInfo(name="updated_at")
	var updatedAt: String? = null,

	@ColumnInfo(name="site_admin")
	var siteAdmin: Boolean? = null,

	@ColumnInfo(name="company")
	var company: String? = null,

	@PrimaryKey
	@ColumnInfo(name="id")
	var id: Int? = null,

	@ColumnInfo(name="public_repos")
	var publicRepos: Int? = null,

	@ColumnInfo(name="gravatar_id")
	var gravatarId: String? = null,

	@ColumnInfo(name="email")
	var email: String? = null,

	@ColumnInfo(name="organizations_url")
	var organizationsUrl: String? = null,

	@ColumnInfo(name="hireable")
	var hireable: Boolean? = null,

	@ColumnInfo(name="starred_url")
	var starredUrl: String? = null,

	@ColumnInfo(name="followers_url")
	var followersUrl: String? = null,

	@ColumnInfo(name="public_gists")
	var publicGists: Int? = null,

	@ColumnInfo(name="url")
	var url: String? = null,

	@ColumnInfo(name="received_events_url")
	var receivedEventsUrl: String? = null,

	@ColumnInfo(name="followers")
	var followers: Int? = null,

	@ColumnInfo(name="avatar_url")
	var avatarUrl: String? = null,

	@ColumnInfo(name="events_url")
	var eventsUrl: String? = null,

	@ColumnInfo(name="html_url")
	var htmlUrl: String? = null,

	@ColumnInfo(name="following")
	var following: Int? = null,

	@ColumnInfo(name="name")
	var name: String? = null,

	@ColumnInfo(name="location")
	var location: String? = null,

	@ColumnInfo(name="node_id")
	var nodeId: String? = null
) {
	constructor(user: User) :  this(
		user.gistsUrl,user.reposUrl,user.followingUrl,user.bio,user.createdAt,user.login,user.type,
		user.blog,user.subscriptionsUrl,user.updatedAt,user.siteAdmin,user.company,user.id,user.publicRepos,
		user.gravatarId,user.email,user.organizationsUrl,user.hireable,user.starredUrl,user.followersUrl,user.publicGists,
		user.url,user.receivedEventsUrl,user.followers,user.avatarUrl,user.eventsUrl,user.htmlUrl,user.following,user.name,
		user.location,user.nodeId
	)
}