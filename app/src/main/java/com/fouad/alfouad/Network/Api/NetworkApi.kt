package com.fouad.alfouad.Network.Api

import com.fouad.alfouad.ForwardResponse
import com.fouad.alfouad.Model.SpDoctors.ResponseSp
import com.fouad.alfouad.Model.auth.AuthResponse
import com.fouad.alfouad.Model.best_doctors.BestDoctors
import com.fouad.alfouad.Model.best_hospitals.BestHospitals
import com.fouad.alfouad.Model.clink.Clink
import com.fouad.alfouad.Model.create_pation.CreatePationResponse
import com.fouad.alfouad.Model.doctor.DoctorData
import com.fouad.alfouad.Model.doctor_hospitals.ResponseDoctorHospitals
import com.fouad.alfouad.Model.hospital.HospitalBojo
import com.fouad.alfouad.Model.pation.PationResponse
import com.fouad.alfouad.Model.pharmacy.PharmacyResponse
import com.fouad.alfouad.Model.specialization_doctors.SpecializationDoctorsResponse
import com.fouad.alfouad.Model.specialization_doctors.all_sp.AllSpResponse
import com.fouad.alfouad.Model.specializations_hospital.SpecializationHospitalResponse
import com.fouad.alfouad.Model.specializations_hospital.all_sp_hospitals.ResponseHospitalSp
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface NetworkApi {

    @GET("hospital")
    suspend fun getHospitals(): Response<HospitalBojo>
    @GET("bestHospitals")
    suspend fun bestHospitals(): Response<BestHospitals>
    @GET("bestDoctors")
    suspend fun bestDoctors(): Response<BestDoctors>

    @GET("hospital/{id}")
    suspend fun getHospital(@Path("id") hospitalId: Int): Response<ResponseDoctorHospitals>

    @GET("doctors/{id}")
    suspend fun getDoctors(@Path("id") doctor_id: Int): Response<DoctorData>

    @GET("pations/{id}")   //get Pation Forwards just
    suspend fun forwards(@Path("id") forward_id: Int): Response<ForwardResponse>

    @GET("pations/{id}")    //get Pation Info
    suspend fun pation(@Path("id") pation_id: Int): Response<PationResponse>

    @GET("pations")    //get all Pation Info
    suspend fun allpations(): Response<CreatePationResponse>

    @POST("pations")    //get all Pation Info
    suspend fun register(): Response<PationResponse>

    @GET("pharmacy")
    suspend fun getPharmacy(): Response<PharmacyResponse>

    @GET("pharmacy/{id}")
    suspend fun getPharmacyData(@Path("id") pharmacy_id: Int): Response<PharmacyResponse>
    @GET("pharmacy/{id}")
    suspend fun getPharmacyStaff(@Path("id") pharmacy_id: Int): Response<PharmacyResponse>

    @GET("specializationDoctors/{id}") //كل الاطباء بالنسبة لهذا التخصص
    suspend fun getDoctorSpecialization(@Path("id") doctor_id: Int): Response<ResponseSp>
  @GET("specializationDoctors/{id}") //كل الاطباء بالنسبة لهذا التخصص
    suspend fun getResponseSp(@Path("id") doctor_id: Int): Response<ResponseSp>

    @GET("specializationDoctors") // all sp with his doctors
    suspend fun getAllDoctorSpecializations(): Response<AllSpResponse>

    @GET("specializations/{id}")
    suspend fun getHospitalSpecialization(@Path("id") specialization_id: Int): Response<SpecializationHospitalResponse>

    @GET("specializationDoctors")
    suspend fun getAllHospitalSpecialization(): Response<ResponseHospitalSp>

    @GET("clink")
    suspend fun getClinks(): Response<Clink>

    @FormUrlEncoded
    @POST("apis/login.php")
    suspend fun login(@Field("phone") phone: String) : Response<AuthResponse>

    @FormUrlEncoded
    @POST("authPation")
    suspend fun auth_(@Field("phone") phone: String) : AuthResponse
}