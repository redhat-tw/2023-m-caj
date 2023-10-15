import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  /**
   *
   * app config
   * @private
   * @type {*}
   * @memberof AppService
   */
  appConfig: any;

  /**
    * 預設訂位請求
    * @type {*}
    * @memberof AppService
    */
  reservationRequestDefault: any = {
    serviceType: '1',
    roundTrip: '1',
    passengers: [
      {
        // 全票
        type: '1',
        amt: 0,
      },
      {
        // 孩童
        type: '2',
        amt: 0,
      },
      {
        // 敬老
        type: '3',
        amt: 0,
      },
      {
        // 愛心
        type: '4',
        amt: 0,
      },
    ],
    departure: '1',
    destination: '1',
    outbound: {
      trainNo: '',
      departureTime: '',
      arrivalTime: '',
      classCode: 'Y'
    },
    inbound: {
      trainNo: '',
      departureTime: '',
      arrivalTime: '',
      classCode: 'Y'
    },
    memberType: '1', // 1 無 , 2 企業 , 3 XGO
    memberId: null,
    paymentMethod: '1', // 1 現金
    paymentAmt: 0
  };

  /**
   * 訂位請求
   * @type {*}
   * @memberof AppService
   */
  reservationRequest: any = {
    serviceType: '1',
    roundTrip: '1',
    passengers: [
      {
        // 全票
        type: '1',
        amt: 0,
      },
      {
        // 孩童
        type: '2',
        amt: 0,
      },
      {
        // 敬老
        type: '3',
        amt: 0,
      },
      {
        // 愛心
        type: '4',
        amt: 0,
      },
    ],
    departure: '1',
    destination: '1',
    outbound: {
      trainNo: '',
      departureTime: '',
      arrivalTime: '',
      classCode: 'Y'
    },
    inbound: {
      trainNo: '',
      departureTime: '',
      arrivalTime: '',
      classCode: 'Y'
    },
    memberType: '1', // 1 無 , 2 企業 , 3 XGO
    memberId: null,
    paymentMethod: '1', // 1 現金
    paymentAmt: 0
  };

  /**
   * 訂位查詢請求
   * @type {*}
   * @memberof AppService
   */
  ticketQueryRequest: any = {
    pnr: null,
  }


  constructor(public http: HttpClient) {

  }

  async loadAppConfig() {
    const data = await this.http.get('/assets/config.json').toPromise();
    this.appConfig = data;
  }

  get apiConfig() {
    if (!this.appConfig) {
      return this.appConfig;
    }
    return this.appConfig;
  }

}
