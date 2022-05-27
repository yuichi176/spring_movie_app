'use strict'

{
    const menu_open = document.querySelector(".menu-btn")
    const menu_close = document.querySelector(".menu-close")
    const menu = document.querySelector(".menu-wrapper")
    const overlay = document.querySelector(".overlay")

    // menu open
    menu_open.addEventListener('click', () => {
        menu.classList.add("show")
        overlay.classList.add("show")
    })

    // menu close
    menu_close.addEventListener('click', () => {
        menu.classList.remove("show")
        overlay.classList.remove("show")
    })

    overlay.addEventListener('click', () => {
        if(overlay.classList.contains('show')){
            overlay.classList.remove('show');
            menu.classList.remove('show');
        }
    })
}