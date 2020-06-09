import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  searchForm: FormGroup

  input: string;
  chunk: string[];
  totalItem = 0;
  perPage = 20;
  page = 1;
  loading = false;

  constructor(
    private dataService: DataService,
    private formBuilder: FormBuilder
  ) { 
    this.searchForm = this.formBuilder.group({
      input: ['', [Validators.required]]
    })
  }

  ngOnInit(): void {    
  }

  fetchData() {
    if (this.searchForm.valid) {
      this.chunk = [];
      this.loading = true;
      this.dataService.fetchData(this.input, this.page).subscribe(res => {
        this.chunk = res.body.data;
        this.totalItem = res.body.count;
        this.perPage = res.body.defalutSize;
        this.loading = false;
      }, err => {
        this.loading = false;
      });
    }
  }

  onFetch() {
    this.page = 1;
    this.fetchData();
  }

  next() {
    if (this.page <= this.totalItem / this.perPage) {
      this.page++;
      this.fetchData();
    }    
  }

  previous() {
    if (this.page > 1) {
      this.page--;
      this.fetchData();
    }
  }
}
