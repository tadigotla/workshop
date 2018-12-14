package com.sample

import geb.Page


public class GameListPage extends Page{
    static url = "/video-game/game/index"

    static content = {
        createButton {$('a.create')}
    }

}