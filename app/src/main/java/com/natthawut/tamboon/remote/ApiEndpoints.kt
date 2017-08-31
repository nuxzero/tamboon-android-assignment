package com.natthawut.tamboon.remote

import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiEndpoints {

    @GET("/")
    fun getOrganizations(): Observable<List<Charity>>

    @POST("/donate")
    fun donate(@Body donation: Donation): Observable<DonationResponse>

}
