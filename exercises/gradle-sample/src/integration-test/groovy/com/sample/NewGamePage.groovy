package com.sample

import geb.Page


public class NewGamePage extends Page {

    static at = {
        title == 'Create Game'
    }

    static content = {
        name {$('#name')}
        publisher {$('#publisher')}
        platform {$('#platform')}
        createButton {$('input.save')}
    }
}