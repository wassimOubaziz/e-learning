
const navBtnMobile = document.querySelector(
  ".navigation .container .mobile-btn"
);
const navBarMobile = document.querySelector(".navigation .container .mobile");
const body = document.querySelector("body");
let links = [];

//show and remove mobile NavBar
navBtnMobile.addEventListener("click", () => {
  navBarMobile.classList.toggle("active");
  links = document.querySelectorAll(".navigation .container .mobile ul li");

  if (navBarMobile.classList.contains("active")) {
    body.style.overflow = "hidden";
  } else {
    body.style.overflow = "auto";
  }
  links.forEach((link) => {
    link.addEventListener("click", () => {
      navBarMobile.classList.remove("active");
      body.style.overflow = "auto";
    });
  });
});

// make animation

const observation = new IntersectionObserver((entries) => {
  entries.forEach((entry) => {
    if (entry.isIntersecting) {
      entry.target.classList.add("show");
    } else {
      entry.target.classList.toggle("show");
    }
  });
});

const cards = document.querySelectorAll(".service .container .teacher");

cards.forEach((card) => observation.observe(card));
