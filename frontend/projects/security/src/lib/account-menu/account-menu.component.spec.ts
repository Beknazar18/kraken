import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {AccountMenuComponent} from './account-menu.component';
import {SecurityConfigurationService} from 'projects/security/src/lib/security-configuration.service';
import {SecurityService} from 'projects/security/src/lib/security.service';
import {securityServiceSpy} from 'projects/security/src/lib/security.service.spec';

describe('AccountMenuComponent', () => {
  let component: AccountMenuComponent;
  let fixture: ComponentFixture<AccountMenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [AccountMenuComponent],
      providers: [
        {provide: SecurityService, useValue: securityServiceSpy()},
      ]
    })
      .overrideTemplate(AccountMenuComponent, '')
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccountMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
