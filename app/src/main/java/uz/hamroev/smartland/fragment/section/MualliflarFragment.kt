package uz.hamroev.smartland.fragment.section

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.hamroev.smartland.R
import uz.hamroev.smartland.adapter.AuthorAdapter
import uz.hamroev.smartland.cache.Cache
import uz.hamroev.smartland.databinding.FragmentMualliflarBinding
import uz.hamroev.smartland.model.Author


class MualliflarFragment : Fragment() {


    lateinit var binding: FragmentMualliflarBinding
    lateinit var authorAdapter: AuthorAdapter
    lateinit var listAuthor: ArrayList<Author>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMualliflarBinding.inflate(layoutInflater, container, false)

        binding.backIv.setOnClickListener {
            findNavController().popBackStack()
        }

        loadAuthors()
        authorAdapter = AuthorAdapter(binding.root.context, listAuthor)
        binding.rvAuthor.adapter = authorAdapter



        return binding.root
    }

    private fun loadAuthors() {
        listAuthor = ArrayList()
        when (Cache.language) {
            "en" -> {
                listAuthor.add(
                    Author(
                        "Adizov\nShukhrat\nBafoyevich",
                        "BASIC DOCTORAL STUDENT\n" + "\n" + "TASHKENT INSTITUTE OF IRRIGATION AND AGRICULTURAL MECHANIZATION ENGINEERS NATIONAL RESEARCH UNIVERSITY BUKHARA INSTITUTE OF NATURAL RESOURCES MANAGEMENT\n" + "LECTURER OF THE DEPARTMENT OF LAND RESOURCES USE AND STATE CADASTRE.",
                        R.drawable.user1
                    )
                )
                listAuthor.add(
                    Author(
                        "Kamolov\nJakhongir\nIlkhomovich",
                        "Master's student\n" + "\n" + "TASHKENT INSTITUTE OF IRRIGATION AND AGRICULTURAL MECHANIZATION ENGINEERS NATIONAL RESEARCH UNIVERSITY BUKHARA INSTITUTE OF NATURAL RESOURCES MANAGEMENT\n" + "MASTER'S STUDENT OF THE DEPARTMENT OF LAND RESOURCES USE AND STATE CADASTRE",
                        R.drawable.user2
                    )
                )
                listAuthor.add(
                    Author(
                        "Makhmudov\nMironshokh\nMakhsudovich",
                        "4-year student\n" + "\n" + "TASHKENT INSTITUTE OF IRRIGATION AND AGRICULTURAL MECHANIZATION ENGINEERS NATIONAL RESEARCH UNIVERSITY BUKHARA INSTITUTE OF NATURAL RESOURCES MANAGEMENT\n" + "LAND CADASTRE AND LAND USE GROUP STUDENT",
                        R.drawable.user3
                    )
                )
            }

            "ru" -> {
                listAuthor.add(
                    Author(
                        "Адизов\nШуҳрат\nБафоевич",
                        "БАЗОВЫЙ ДОКТОРАНТ\n" + "\n" + "ТАШКЕНТСКИЙ ИНСТИТУТ ИНЖЕНЕРОВ ИРРИГАЦИИ И МЕХАНИЗАЦИИ СЕЛЬСКОГО ХОЗЯЙСТВА НАЦИОНАЛЬНЫЙ ИССЛЕДОВАТЕЛЬСКИЙ УНИВЕРСИТЕТ БУХАРСКИЙ ИНСТИТУТ УПРАВЛЕНИЯ ПРИРОДНЫМИ РЕСУРСАМИ \n" + "ПРЕПОДАВАТЕЛЬ КАФЕДРЫ ИСПОЛЬЗОВАНИЯ ЗЕМЕЛЬНЫХ РЕСУРСОВ И ГОСУДАРСТВЕННОГО КАДАСТРА.",
                        R.drawable.user1
                    )
                )
                listAuthor.add(
                    Author(
                        "Камолов\nЖахонгир\nИлхомивич",
                        "Магистрант\n" + "\n" + "ТАШКЕНТСКИЙ ИНСТИТУТ ИНЖЕНЕРОВ ИРРИГАЦИИ И МЕХАНИЗАЦИИ СЕЛЬСКОГО ХОЗЯЙСТВА НАЦИОНАЛЬНЫЙ ИССЛЕДОВАТЕЛЬСКИЙ УНИВЕРСИТЕТ БУХАРСКИЙ ИНСТИТУТ УПРАВЛЕНИЯ ПРИРОДНЫМИ РЕСУРСАМИ\n" + "МАГИСТРАНТ КАФЕДРЫ ИСПОЛЬЗОВАНИЯ ЗЕМЕЛЬНЫХ РЕСУРСОВ И ГОСУДАРСТВЕННОГО КАДАСТРА",
                        R.drawable.user2
                    )
                )
                listAuthor.add(
                    Author(
                        "Маҳмудов\nМироншоҳ\nМақсудвич",
                        "Студент 4 курса\n" + "\n" + "ТАШКЕНТСКИЙ ИНСТИТУТ ИНЖЕНЕРОВ ИРРИГАЦИИ И МЕХАНИЗАЦИИ СЕЛЬСКОГО ХОЗЯЙСТВА НАЦИОНАЛЬНЫЙ ИССЛЕДОВАТЕЛЬСКИЙ УНИВЕРСИТЕТ БУХАРСКИЙ ИНСТИТУТ УПРАВЛЕНИЯ ПРИРОДНЫМИ РЕСУРСАМИ\n" + "СТУДЕНТ ГРУППЫ ЗЕМЕЛЬНОГО КАДАСТРА И ЗЕМЛЕПОЛЬЗОВАНИЯ",
                        R.drawable.user3
                    )
                )
            }

            "uz" -> {
                listAuthor.add(
                    Author(
                        "Adizov\nShuhrat\nBafoyevich",
                        "TAYANCH DOKTORANT\n" + "\n" + "TOSHKENT IRRIGATSIYA VA QISHLOQ XO'JALIGINI MEXANIZATSIYALASH MUHANDISLARI INSTITUTI MILLIY TADQIQOT UNVERSITETI  BUXORO TABIIY RESURSLARNI BOSHQARISH INSTITUTI \n" + "YER RESURSLARIDAN FOYDALANISH VA DAVLAT KADASTRLARI KAFEDRASI O'QITUVCHISI.",
                        R.drawable.user1
                    )
                )
                listAuthor.add(
                    Author(
                        "Kamolov\nJaxongir\nIlxomivich",
                        "MAGISTRANT\n" + "\n" + "TOSHKENT IRRIGATSIYA VA QISHLOQ XO'JALIGINI MEXANIZATSIYALASH MUHANDISLARI INSTITUTI MILLIY TADQIQOT UNVERSITETI  BUXORO TABIIY RESURSLARNI BOSHQARISH INSTITUTI \n" + "YER RESURSLARIDAN FOYDALANISH VA DAVLAT KADASTRLARI KAFEDRASI MAGISTRANTI",
                        R.drawable.user2
                    )
                )
                listAuthor.add(
                    Author(
                        "Mahmudov\nMironshoh\nMaqsud o'g'li",
                        "4-kurs talabasi\n" + "\n" + "TOSHKENT IRRIGATSIYA VA QISHLOQ XO'JALIGINI MEXANIZATSIYALASH MUHANDISLARI INSTITUTI MILLIY TADQIQOT UNVERSITETI  BUXORO TABIIY RESURSLARNI BOSHQARISH INSTITUTI \n" + "YER KADASTRI VA YERDAN FOYDALANISH GURUH TALABASI",
                        R.drawable.user3
                    )
                )
            }
        }

    }

}
