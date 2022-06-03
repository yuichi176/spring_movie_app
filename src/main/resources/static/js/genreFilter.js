'use strict'

{
    const genreFilter = document.querySelectorAll('.genre-filter-item')
    const list = document.querySelectorAll('.movie-row')

    genreFilter.forEach((filter_btn) => {
        filter_btn.addEventListener('click', () => {
            list.forEach((row) => {
                console.log("hello")
                row.classList.remove("show")
            })

            genreFilter.forEach((filter_btn) => {
                filter_btn.classList.remove("active")
            })
            filter_btn.classList.add("active")

            const btn_genre = filter_btn.dataset.filter
            if (btn_genre === 'all') {

                list.forEach((row) => {
                    row.classList.add("show")
                })

            } else {

                list.forEach((row) => {
                    if(row.dataset.genre === btn_genre) {
                        row.classList.add("show")
                    }
                })

            }
        })
    })
}