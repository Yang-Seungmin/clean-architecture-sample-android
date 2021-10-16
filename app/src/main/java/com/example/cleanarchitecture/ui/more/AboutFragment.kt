package com.example.cleanarchitecture.ui.more

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.danielstone.materialaboutlibrary.MaterialAboutFragment
import com.danielstone.materialaboutlibrary.items.MaterialAboutActionItem
import com.danielstone.materialaboutlibrary.items.MaterialAboutTitleItem
import com.danielstone.materialaboutlibrary.model.MaterialAboutCard
import com.danielstone.materialaboutlibrary.model.MaterialAboutList
import com.example.cleanarchitecture.MainActivity
import com.example.cleanarchitecture.R

class AboutFragment : MaterialAboutFragment() {

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).showBackButton(false)
        (activity as MainActivity).supportActionBar?.title = getString(R.string.about)
    }

    override fun getMaterialAboutList(activityContext: Context): MaterialAboutList {
        val appItem = MaterialAboutTitleItem.Builder()
            .text(getString(R.string.app_name))
            .desc(getString(R.string.home_main_description))
            .icon(R.mipmap.ic_launcher)
            .build()

        val versionItem = MaterialAboutActionItem.Builder()
            .text(getString(R.string.version))
            .subText(
                requireContext().packageManager.getPackageInfo(
                    requireContext().packageName,
                    0
                ).versionName
            )
            .icon(R.drawable.ic_outline_info_24)
            .build()

        val mainCard = MaterialAboutCard.Builder()
            .addItem(appItem)
            .addItem(versionItem)
            .build()


        val authorNameItem = MaterialAboutActionItem.Builder()
            .text(getString(R.string.app_author))
            .subText(getString(R.string.app_author_region))
            .icon(R.drawable.ic_outline_person_24)
            .setOnClickAction {
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/Yang-Seungmin")
                ).also { startActivity(it) }
            }
            .build()

        val sourceCodeItem = MaterialAboutActionItem.Builder()
            .text(getString(R.string.view_source_code))
            .icon(R.drawable.github_mark)
            .setOnClickAction {
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/Yang-Seungmin/clean-architecture-sample-android")
                ).also { startActivity(it) }
            }
            .build()

        val authorCard = MaterialAboutCard.Builder()
            .title(getString(R.string.author))
            .addItem(authorNameItem)
            .addItem(sourceCodeItem)
            .build()


        val jetpackLibrary = MaterialAboutActionItem.Builder()
            .text("Android Jetpack")
            .subText("Lifecycle KTX\nFragment KTX\nNavigation KTX\nPaging 3\nSwipe Refresh Layout\n")
            .setOnClickAction {
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/androidx")
                ).also { startActivity(it) }
            }
            .build()

        val hiltLibrary = MaterialAboutActionItem.Builder()
            .text("Hilt")
            .setOnClickAction {
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/googlecodelabs/android-hilt")
                ).also { startActivity(it) }
            }
            .build()

        val retrofitLibrary = MaterialAboutActionItem.Builder()
            .text("Retrofit 2")
            .setOnClickAction {
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/square/retrofit")
                ).also { startActivity(it) }
            }
            .build()

        val materialAboutLibrary = MaterialAboutActionItem.Builder()
            .text("material-about-library")
            .setOnClickAction {
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/daniel-stoneuk/material-about-library")
                ).also { startActivity(it) }
            }
            .build()

        val techStacksAndLibrariesCard = MaterialAboutCard.Builder()
            .title(getString(R.string.open_source_libraries))
            .addItem(jetpackLibrary)
            .addItem(hiltLibrary)
            .addItem(retrofitLibrary)
            .addItem(materialAboutLibrary)
            .build()

        return MaterialAboutList(mainCard, authorCard, techStacksAndLibrariesCard)
    }

}