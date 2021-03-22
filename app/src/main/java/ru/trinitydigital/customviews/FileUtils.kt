package ru.trinitydigital.customviews

import com.google.gson.Gson
import ru.trinitydigital.customviews.model.MainModel
import java.io.IOException

const val WORDS_PATH = "recipes/recipes.json"

object FileUtils {

    @JvmStatic
    fun loadJSONFromAsset(filePath: String): String? {
        var json: String? = null
        try {
            val `is` = CustomViewsApp.applicationContext().assets.open(filePath)
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            json = String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }

    fun getRecipesData() : MainModel {
        val json = loadJSONFromAsset(WORDS_PATH)
        val gson = Gson().fromJson(json, MainModel::class.java)
        return gson
    }
//
//    fun getTrophyData() : List<TrophyModel> {
//        val json = loadJSONFromAsset(TROPHY_PATH)
//        val gson = Gson().fromJson<TrophyModelList>(json, TrophyModelList::class.java)
//        return gson.rewards
//    }
//
//    fun getRoomData() : List<RoomModel> {
//        val json = loadJSONFromAsset(ROOM_PATH)
//        val gson = Gson().fromJson<RoomModelList>(json, RoomModelList::class.java)
//        return gson.rooms
//    }

}