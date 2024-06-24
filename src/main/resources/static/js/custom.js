
  $(function () {

    // MENU
    $('.navbar-collapse a').on('click',function(){
      $(".navbar-collapse").collapse('hide');
    });

    // AOS ANIMATION
    AOS.init({
      disable: 'mobile',
      duration: 800,
      anchorPlacement: 'center-bottom'
    });


    // SMOOTHSCROLL NAVBAR
    $(function() {
      $('.navbar a, .hero-text a').on('click', function(event) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: $($anchor.attr('href')).offset().top - 49
        }, 1000);
        event.preventDefault();
      });
    });
  });


  const cards = document.querySelectorAll(".mov-card");
  const forPppUp2 = document.querySelector(".forPppUp");
  const  cancel = document.getElementById("cancel");
  const movement_id = document.querySelector(".movement_id");
  cards.forEach((card, index) => {
    const addbtn = card.querySelector(".btnAdd");
    addbtn.addEventListener("click" , ()=>{
      movement_id.value = addbtn.value;
      console.log(movement_id.value);
      forPppUp2.style.display = "flex";

    })
    cancel.addEventListener("click" , ()=>{
      forPppUp2.style.display = "none";
    })

  });


