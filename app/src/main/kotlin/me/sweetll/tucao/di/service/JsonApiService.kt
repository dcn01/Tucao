package me.sweetll.tucao.di.service

import io.reactivex.Observable
import me.sweetll.tucao.business.drrr.model.DrrrResponse
import me.sweetll.tucao.business.drrr.model.Post
import me.sweetll.tucao.business.drrr.model.Reply
import me.sweetll.tucao.model.json.Video
import me.sweetll.tucao.business.video.model.ReplyResponse
import me.sweetll.tucao.model.json.BaseResponse
import me.sweetll.tucao.model.json.ListResponse
import me.sweetll.tucao.model.json.Version
import retrofit2.http.GET
import retrofit2.http.Query

interface JsonApiService {
    @GET(ApiConfig.VIEW_API_URL)
    fun view(@Query("hid") hid: String): Observable<BaseResponse<Video>>

    @GET(ApiConfig.LIST_API_URL)
    fun list(@Query("tid") tid: Int,
             @Query("page") pageIndex: Int,
             @Query("pagesize") pageSize: Int,
             @Query("order") order: String?): Observable<ListResponse<Video>>

    @GET(ApiConfig.SEARCH_API_URL)
    fun search(@Query("tid") tid: Int?,
               @Query("page") pageIndex: Int,
               @Query("pagesize") pageSize: Int,
               @Query("order") order: String?,
               @Query("q") keyword: String): Observable<ListResponse<Video>>

    @GET(ApiConfig.RANK_API_URL)
    fun rank(@Query("tid") tid: Int,
             @Query("date") date: Int): Observable<BaseResponse<Map<Int, Video>>>

    @GET(ApiConfig.UPDATE_API_URL)
    fun update(@Query("appKey") appKey: String,
               @Query("appSecret") appSecret: String,
               @Query("versionCode") versionCode: Int): Observable<Version>

    @GET(ApiConfig.REPLY_API_URL)
    fun reply(@Query("commentid") commentId: String,
              @Query("replyid") replyId: String,
              @Query("page") page: Int,
              @Query("num") num: Int): Observable<ReplyResponse>

    @GET(ApiConfig.POSTS_API_URL)
    fun drrrPosts(@Query("page") page: Int,
                  @Query("size") size: Int,
                  @Query("sortBy") sortBy: String,
                  @Query("order") order: String): Observable<DrrrResponse<List<Post>>>

    @GET(ApiConfig.REPLIES_API_URL)
    fun drrrReplies(@Query("page") page: Int,
                    @Query("size") size: Int): Observable<DrrrResponse<List<Reply>>>

}
