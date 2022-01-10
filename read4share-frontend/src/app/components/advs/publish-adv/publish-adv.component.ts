import { Component, OnInit } from '@angular/core';
import { SearchBookResult } from 'src/app/interfaces/SearchBookResult';
import { AdvService } from 'src/app/services/adv.service';

@Component({
  selector: 'app-publish-adv',
  templateUrl: './publish-adv.component.html',
  styleUrls: ['./publish-adv.component.css'],
})
export class PublishAdvComponent implements OnInit {
  bookForm: any = {
    title: '',
    author: '',
  };
  advForm: any = {
    description: '',
    price: '',
    shipCost: null,
    condCode: '',
    pen: false,
    pencil: false,
    highl: false,
  };
  selectedBook?: SearchBookResult;
  bookChosen: boolean = true;
  searchBookResult: SearchBookResult[] = [];

  constructor(private advService: AdvService) {}

  ngOnInit(): void {}

  onSearch() {
    const { title, author } = this.bookForm;

    if (title != '' || author != '') {
      this.advService.searchBook(title, author).subscribe(
        (result) => {
          this.searchBookResult = result;
        },
        (err) => {
          console.log(err.error.message);
        }
      );
    }
  }

  onSelectBook(index: number) {
    this.selectedBook = this.searchBookResult[index];
  }

  onPublish() {
    console.log(JSON.stringify(this.advForm));
  }
}
