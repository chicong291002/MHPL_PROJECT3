$(document).ready(function () {
    const cartData = JSON.parse(localStorage.getItem("detailCart"))
    if (cartData === null || cartData === undefined) {
        localStorage.setItem("detailCart", JSON.stringify([]))
    }
})