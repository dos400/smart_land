package uz.hamroev.smartland.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.squareup.okhttp.Cache
import uz.hamroev.smartland.R
import uz.hamroev.smartland.databinding.FragmentKirishBinding
import uz.hamroev.smartland.db.daromad.DaromadDatabase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [KirishFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class KirishFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var binding: FragmentKirishBinding
    private val TAG = "KirishFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKirishBinding.inflate(layoutInflater)


        binding.backIv.setOnClickListener {
            findNavController().popBackStack()
        }
        when (uz.hamroev.smartland.cache.Cache.language) {
            "uz" -> {
                binding.info.text = """
                    “SMART LAND” (AQLLI YER)
                                 Yer azaldan xalqning eng asosiy va bebaho boyligi, chinakam umumxalq mulki  bo’lib kelgan. U jahon milliy boyligining eng muhim qismi, ishlab chiqarishni yuritishning asosiy negizidir. Ayniqsa yer qishloq xo‘jalik ishlab chiqarishida muhim vosita rolini bajaradi. Barchaga ma’lumki, bugungi murakkab va qaltis davr dunyo miqyosida agrar sohaning hal qiluvchi o‘rni va ahamiyatini yana bir bor yaqqol ko‘rsatib bermoqda. Dunyoda global oziq-ovqat yetishmovchiligi xavfi yuzaga kelayotgan bugungi vaziyatda bizda ichki bozorimizni to‘liq ta’minlash bilan birga, qishloq xo‘jaligi mahsulotlari yetishtirish hajmini ikki barobar oshirish va eksportni ko‘paytirish uchun barcha sharoitlar yaratish maqsadida ushbu dastur yaratildi.
                                 Prezidentimiz Shavkat Mirziyoyev raisligida 2022 yil 18-iyulda bo’lib o’tgan videosellektor yig’ilishida “Ekin yerlari va tomorqadan samarali foydalanish orqali oziq-ovqat yetishtirishni va aholi daromadlarini ko‘paytirish” masalasi aytib o’tildi. 
                                Bu dasturning  asosiy vazifasi 
                        • Yer maydonini o’lchamini kiritish hisobiga(ehtiyoj asosida) ekin turi bo’yicha taqsimlab beradi; 
                        • Ekin turlarining agrotexnikasi to’liq ko’rsatilgan;
                        • Tomorqa maydonida ekiladigan ekin uchun qilinishi kerak bo’lgan sarf-xarajatlarini hisoblab beradi; 
                        • Tomorqa maydonida ekilgan ekindan olinadigan  daromadni va foydalanuvchiga sof foyda haqidagi ma’lumotlarni hisoblab beradi.
                                 Bu dasturni yaratishdan maqsad qishloq xo’jaligi yer turlaridan (tomorqa yer maydonlari) samarsiz foydalanishni oldini olish ham aholi daromadlarni ko’paytirish maqsadida yaratilgan. 


                      """.trimIndent()
            }
            "ru" -> {
                binding.info.text = """
                    "СМАРТ ЛЭНД"
             Земля всегда была самым главным и бесценным богатством народа, реальной общественной собственностью. Это важнейшая часть мирового национального богатства, основная основа производства. В частности, земля играет роль важного орудия сельскохозяйственного производства. Как всем известно, сегодняшний сложный и неспокойный период еще раз наглядно показывает решающую роль и значение аграрного сектора в мировом масштабе. Эта программа создана для того, чтобы удвоить объем производства сельскохозяйственной продукции и увеличить экспорт, при этом обеспечить полное обеспечение нашего внутреннего рынка в сегодняшней ситуации, когда в мире возникает риск глобального дефицита продовольствия.
             На совещании видеоселекторов, состоявшемся 18 июля 2022 года под председательством Президента Шавката Мирзиёева, был затронут вопрос «Увеличения производства продуктов питания и доходов населения за счет эффективного использования пашни и земель».
            Это основная задача программы
    • Делит земельный участок по видам культур (исходя из потребности);
    • Полностью показана агротехника видов культур;
    • Рассчитывает расходы, которые необходимо понести за посеянные в поле культуры;
    • Рассчитывает доход от урожая, посаженного на поле, и информацию о чистой прибыли для пользователя.
             Целью создания данной программы является предотвращение неэффективного использования земель сельскохозяйственного назначения (сельхозугодий) и увеличение доходов населения.
                      """.trimIndent()
            }
            "en" -> {
                binding.info.text = """
                   "SMART LAND"
             The land has always been the most important and priceless wealth of the people, a real public property. It is the most important part of the world's national wealth, the main basis of production. In particular, land plays the role of an important tool in agricultural production. As everyone knows, today's complex and volatile period once again clearly shows the decisive role and importance of the agrarian sector on the world scale. This program was created in order to double the volume of agricultural production and increase exports, while ensuring the full supply of our domestic market in today's situation, when the risk of global food shortages is emerging in the world.
             At the meeting of video selectors held on July 18, 2022 under the chairmanship of President Shavkat Mirziyoyev, the issue of "Increasing food production and population incomes through effective use of arable land and land" was mentioned.
            This is the main task of the program
    • Divides the land area according to the type of crop (based on need);
    • Agrotechnics of crop types are fully shown;
    • Calculates the expenses that must be incurred for the crops planted in the field;
    • Calculates the income from the crops planted in the field and information about the net profit to the user.
             The purpose of creating this program is to prevent inefficient use of agricultural land (farmland) and to increase the income of the population.
                      """.trimIndent()
            }
        }


        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment KirishFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            KirishFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}