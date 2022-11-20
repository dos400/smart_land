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
                    SMART LAND” (AQLLI YER)
             Yer azaldan xalqning eng asosiy va bebaho boyligi, chinakam umumxalq mulki  hisoblanadi. U jahon milliy boyligining eng muhim qismi, ishlab chiqarishni yuritishning asosiy negizidir. Ayniqsa yer qishloq xo‘jalik ishlab chiqarishida muhim vosita rolini bajaradi. Barchangiz guvoh bo‘lib turibsiz, bugungi murakkab va qaltis davr dunyo miqyosida agrar sohaning hal qiluvchi o‘rni va ahamiyatini yana bir bor yaqqol ko‘rsatib bermoqda. Dunyoda global oziq-ovqat yetishmovchiligi xavfi yuzaga kelayotgan bugungi vaziyatda bizda ichki bozorimizni to‘liq ta’minlash bilan birga, qishloq xo‘jaligi mahsulotlari yetishtirish hajmini ikki barobar oshirish va eksportni ko‘paytirish uchun barcha sharoitlar yaratish maqsadida bu dastur yaratildi.
             Prezidentimiz Shavkat Mirziyoyev raisligida 2022yil 18-iyulda bo’lib o’tgan videoseliktor yig’ilishida “Ekin yerlari va tomorqadan samarali foydalanish orqali oziq-ovqat yetishtirishni va aholi daromadlarini ko‘paytirish” masalasi prezidentimiz tomonidan aytib o’tildi. 
            Bu dasturning  asosiy vazifasi 
    • Ekin yer maydonini o’lchamini kiritsangiz sizga yer maydonini ekin turi bo’yicha taqsimlab beradi; 
    • Ekin turlarining agrotexnikasi ko’rsatilgan;
    • Tomorqa maydonida ekilgan ekinga ketgan xarajatlarini hisoblab beradi; 
    • Tomorqa maydonida ekilgan ekindan olinadigan  daromadni hisoblab beradi;
 hamda sizga sof foyda qancha qolishini aytib turadi.
             Bu dasturni yaratishdan maqsad yerlardan samarsiz foydalanishni oldini olish ham aholi daromadlarni ko’paytirish maqsadida yaratildi. 
           """.trimIndent()
            }
            "ru" -> {
                binding.info.text = """
                    УМНАЯ ЗЕМЛЯ"
             Земля — самое главное и бесценное богатство народа, реальная общественная собственность. Это важнейшая часть мирового национального богатства, основная основа производства. В частности, земля играет роль важного орудия сельскохозяйственного производства. Все вы были свидетелями того, что сегодняшнее сложное и нестабильное время еще раз наглядно показывает решающую роль и значение аграрного сектора в мировом масштабе. Эта программа создана для того, чтобы удвоить объем производства сельскохозяйственной продукции и увеличить экспорт, при этом обеспечить полное обеспечение нашего внутреннего рынка в сегодняшней ситуации, когда в мире возникает риск глобального дефицита продовольствия.
             На совещании видеоселекторов, состоявшемся 18 июля 2022 года под председательством Президента Шавката Мирзиёева, нашим Президентом был затронут вопрос «Увеличения производства продуктов питания и доходов населения за счет эффективного использования пашни и земель».
            Это основная задача программы
    • Если вы введете размер обрабатываемой площади земли, она будет распределять площадь земли в соответствии с типом культуры;
    • Показаны агротехнические приемы по видам культур;
    • Рассчитывает затраты культур, посаженных в поле;
    • Рассчитывает доход от урожая, посаженного на ферме;
 и сообщает вам, сколько чистой прибыли осталось.
             Целью создания этой программы было предотвращение неэффективного использования земли и увеличение доходов населения.
                """.trimIndent()
            }
            "en" -> {
                binding.info.text = """
                    SMART LAND"
             The land is the most important and priceless wealth of the people, a real public property. It is the most important part of the world's national wealth, the main basis of production. In particular, land plays the role of an important tool in agricultural production. All of you have witnessed that today's complex and unstable times clearly show once again the decisive role and importance of the agrarian sector on the world scale. This program was created in order to double the volume of agricultural production and increase exports, while ensuring the full supply of our domestic market in today's situation, when the risk of global food shortages is emerging in the world.
             At the meeting of video selectors held on July 18, 2022 under the chairmanship of President Shavkat Mirziyoyev, the issue of "Increasing food production and population incomes through effective use of arable land and land" was mentioned by our president.
            This is the main task of the program
    • If you enter the size of the cultivated land area, it will distribute the land area according to the type of crop;
    • Agricultural techniques of crop types are shown;
    • Calculates the costs of crops planted in the field;
    • Calculates the income from crops planted on the farm;
 and tells you how much net profit is left.
             The purpose of creating this program was to prevent inefficient use of land and to increase the income of the population.
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