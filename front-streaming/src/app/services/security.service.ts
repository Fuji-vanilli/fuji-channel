import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { KeycloakProfile } from 'keycloak-js';
import { KeycloakEventType, KeycloakService } from 'keycloak-angular';

@Injectable({
  providedIn: 'root'
})
export class SecurityService {
 
  public profile?: KeycloakProfile;
  
  constructor(public kcService: KeycloakService) {
    this.init();
  }

  init() {
    this.kcService.keycloakEvents$.subscribe({
      next: (e)=> {
        if (e.type== KeycloakEventType.OnAuthSuccess) {
          this.kcService.loadUserProfile().then(profile=> {
            this.profile= profile;
          })
        }
      }
    })
  }

  public hasRoleIn(roles: string[]): boolean{
    let userRoles= this.kcService.getUserRoles();
    for (let role of userRoles) {
      if (userRoles.includes(role))
        return true;
    }
    return false;
  }
}
