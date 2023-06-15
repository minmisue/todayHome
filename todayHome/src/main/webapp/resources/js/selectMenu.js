function selectCurrentMenu(mainMenu, subMenu) {

    if (mainMenu > 0) {
        let currentMenu = $('.menubar-item-bundle').children()[mainMenu]
        $(currentMenu).addClass('selected-item');
    }

    let obj = document.getElementsByClassName('sub-menubar-container')[mainMenu - 1];

    if (subMenu !== null) {
        obj.style.display = 'block';

        if (subMenu > 0) {
            $($(obj).children().children()[subMenu - 1]).addClass('selected-sub-item')
        }
    }
}