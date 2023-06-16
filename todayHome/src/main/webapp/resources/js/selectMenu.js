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

function selectMyPage(mainMenu, subMenu) {

    if (mainMenu > 0) {
        let currentMenu = $('.my-page-menubar-main .sub-menubar').children()[mainMenu-1];
        document.getElementsByClassName('my-page-menubar-main')[0].style.display = 'block';
        console.log(currentMenu);
        $(currentMenu).addClass('selected-my-page-item');
        $(currentMenu).children().addClass('select-arrow');

        let subMenubar = $('.my-page-menubar-sub')[mainMenu-1];

        subMenubar.style.display = 'block';
        $($(subMenubar).children().children()[subMenu-1]).addClass('selected-sub-item')

        $('.main-container').css('margin-top', '230px')
    }

    // let obj = document.getElementsByClassName('sub-menubar-container')[mainMenu - 1];
    //
    // if (subMenu !== null) {
    //     obj.style.display = 'block';
    //
    //     if (subMenu > 0) {
    //         $($(obj).children().children()[subMenu - 1]).addClass('selected-sub-item')
    //     }
    // }
}

// .my-page-menubar-main {
//     /*padding: 0 92px;*/
//     border-top: 1px solid #EBEDEF;
//     display: none;
//     margin: 0;
// }
//
// .my-page-menubar-sub {