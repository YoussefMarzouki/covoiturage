import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
<<<<<<< HEAD
=======
import { AccueilComponent } from "./passager/accueil/accueil.component";
>>>>>>> 768fcdb (controller/service  maps pour recherche des lieux)

@Component({
  selector: 'app-root',
  standalone: true,
<<<<<<< HEAD
  imports: [RouterOutlet],
=======
  imports: [RouterOutlet, AccueilComponent],
>>>>>>> 768fcdb (controller/service  maps pour recherche des lieux)
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'front';
}
