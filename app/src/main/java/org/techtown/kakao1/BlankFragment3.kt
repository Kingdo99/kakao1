package org.techtown.kakao1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import retrofit2.Call
import retrofit2.Response
import org.techtown.kakao1.databinding.FragmentBlank3Binding
import java.text.DecimalFormat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private var _binding: FragmentBlank3Binding? = null
private val binding get() = _binding!!

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment3.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment3 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    val dec = DecimalFormat("#,###")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            retrofitWork()
            retrofitWork2()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBlank3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment3.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment3().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun retrofitWork(){
        val service: EmgMedService = RetrofitApi.emgMedService

        service.getEmgMedData("OaogUjDu9e27k4mltNFCXIVHWAEJKnfyi")

            .enqueue(object : retrofit2.Callback<EmgMedResponse> {
                override fun onResponse(
                    call: Call<EmgMedResponse>,
                    response: Response<EmgMedResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.d("TAG", response.body().toString())
                        // head를 스킵하기 위해 index 1번을 가져옴
                        val result = response.body()
                        with(binding){

                            covidText1.text = "▲"+dec.format(result?.totalCaseBefore?.toInt())
                            covidText2.text = result?.nowCase.toString()
                            covidText3.text = "▲"+result?.todayDeath.toString()
                            covidText4.text = result?.totalDeath.toString()
                        }


                    }
                }

                override fun onFailure(call: Call<EmgMedResponse>, t:  Throwable) {
                    Log.d("TAG", t.message.toString())
                }
            })
    }


    private fun retrofitWork2(){
        val service: EmgMedService2 = RetrofitApi.emgMedService2

        service.getEmgMedData("OaogUjDu9e27k4mltNFCXIVHWAEJKnfyi")

            .enqueue(object : retrofit2.Callback<EmgMedResponse2> {
                override fun onResponse(
                    call: Call<EmgMedResponse2>,
                    response: Response<EmgMedResponse2>
                ) {
                    if (response.isSuccessful) {
                        Log.d("TAG", response.body().toString())
                        // head를 스킵하기 위해 index 1번을 가져옴
                        val result = response.body()
                        val percent = (result?.korea?.vaccine2?.vaccine2?.toDouble()!! / 51317276) * 100

                        binding.covidText5.text = String.format("%.2f", percent)+"%"
                        binding.covidText6.text = dec.format(result?.korea?.vaccine2?.vaccine2)



                    }
                }

                override fun onFailure(call: Call<EmgMedResponse2>, t:  Throwable) {
                    Log.d("TAG", t.message.toString())
                }
            })
    }


}