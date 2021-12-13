import { Component, Input, OnInit, ViewEncapsulation } from '@angular/core';
import { AdvOverview } from 'src/app/interfaces/AdvOverview';
import SwiperCore, { Navigation, Pagination, SwiperOptions } from 'swiper';

// install Swiper modules
SwiperCore.use([Navigation]);
SwiperCore.use([Pagination]);

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.css'],
  encapsulation: ViewEncapsulation.None,
})
export class CarouselComponent implements OnInit {
  // List of Advs Overview to display in the carousel
  @Input() advs?: AdvOverview[];
  swiper: any;

  config: SwiperOptions = {
    allowTouchMove: false,
    navigation: true,
    slidesPerView: 1,
    spaceBetween: 10,
    // Responsive breakpoints
    breakpoints: {
      // when window width is >= 320px
      700: {
        slidesPerView: 2,
        spaceBetween: -40,
      },
      1150: {
        slidesPerView: 3,
        spaceBetween: -40,
      },
      1500: {
        slidesPerView: 4,
        spaceBetween: -40,
      },
      1700: {
        slidesPerView: 5,
        spaceBetween: -40,
      },
      2000: {
        slidesPerView: 6,
        spaceBetween: -40,
      },
    },
  };

  constructor() {}

  ngOnInit(): void {}

  onSwiper(swiper: any) {
    this.swiper = swiper;
  }
  onSlideChange() {
    //let element = document.getElementById('container');
    //console.log('Width: ' + element!.offsetWidth + 'px');
    console.log(window.innerWidth);
  }
}
