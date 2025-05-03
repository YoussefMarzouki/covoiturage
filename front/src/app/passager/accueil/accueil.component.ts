import { Component } from '@angular/core';
import { NavComponent } from '../nav/nav.component';
import { SearchbarComponent } from "../searchbar/searchbar.component";

@Component({
  selector: 'app-accueil',
  standalone: true,
  imports: [NavComponent, SearchbarComponent],
  templateUrl: './accueil.component.html',
  styleUrl: './accueil.component.css'
})
export class AccueilComponent {

}
