import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TokenStorageService } from './services/token-storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  roles?: string[];
  isLoggedIn: boolean = false;
  showAdminBoard = false;
  username?: string;

  constructor(
    private tokenStorageService: TokenStorageService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.showAdminBoard = user!.roles!.includes('ROLE_ADMIN');
      this.username = user!.username;
    }
  }

  logout(): void {
    this.tokenStorageService.signOut();
    this.isLoggedIn = false;
    this.showAdminBoard = false;
    this.router.navigate(['/home']);
    //window.location.reload();
  }
}
