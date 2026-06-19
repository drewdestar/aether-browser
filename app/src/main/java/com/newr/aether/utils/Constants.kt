package com.newr.aether.utils

object Constants {
    const val APP_NAME = "Aether"
    const val APP_VERSION = "1.0.0"
    const val BRAND = "Powered by NEWR"
    const val SLOGAN = "Jelajahi dengan tenang."

    object SearchEngines {
        const val GOOGLE = "https://www.google.com/search?q="
        const val DUCKDUCKGO = "https://www.duckduckgo.com/?q="
        const val BING = "https://www.bing.com/search?q="
        const val YAHOO = "https://search.yahoo.com/search?p="
        const val YANDEX = "https://yandex.com/search/?text="
        const val STARTPAGE = "https://www.startpage.com/sp/search?query="
        const val ECOSIA = "https://www.ecosia.org/search?q="
        const val BRAVE = "https://search.brave.com/search?q="
        const val KAGI = "https://kagi.com/search?q="
        const val QWANT = "https://www.qwant.com/?q="
        const val SEARXNG = "https://searx.space/search?q="
    }

    object Settings {
        const val SEARCH_ENGINE = "search_engine"
        const val TAB_LAYOUT = "tab_layout"
        const val THEME = "theme"
        const val LANGUAGE = "language"
        const val PRIVATE_RELAY = "private_relay"
        const val AUTO_SAVE_PASSWORD = "auto_save_password"
        const val DO_NOT_TRACK = "do_not_track"
        const val BLOCK_ALL_COOKIES = "block_all_cookies"
    }

    object TabLayouts {
        const val COMPACT = "compact"
        const val BOTTOM = "bottom"
        const val TOP = "top"
    }
}
