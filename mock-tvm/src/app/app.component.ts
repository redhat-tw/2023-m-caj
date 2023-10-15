import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppService } from './app.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {


  /**
   * Tittle
   */
  title = 'mock-tvm';

  /**
   * version
   * @memberof AppComponent
   */
  version= 'v1';

  /**
   * 服務類別
   * @type {(any[] | undefined)}
   * @memberof AppComponent
   */
  serviceTypes: any[] | undefined = [
    { name: '自由座', code: '1' },
    { name: '對號座', code: '2' },
    { name: '取票', code: '3' }
  ];

  /**
   * 已選擇的服務類別
   * @type {(any | undefined)}
   * @memberof AppComponent
   */
  selectedServiceType: any | undefined = { name: '自由座', code: '1' };

  /**
   * 單程/去回
   * @type {(any[] | undefined)}
   * @memberof AppComponent
   */
  roundTrip: any[] | undefined = [
    { name: '單程票', code: '1' },
    { name: '去回票', code: '2' }
  ];

  /**
   * 已選擇的單程/去回
   * @type {(any[] | undefined)}
   * @memberof AppComponent
   */
  selectedRoundTrip: any | undefined;

  /**
   * 出發站
   * @type {(any[] | undefined)}
   * @memberof AppComponent
   */
  departures: any[] = [
    {
      id: '1',
      name: '南港',
      code: 'NAK'
    }, {
      id: '2',
      name: '台北',
      code: 'TPE',
    }, {
      id: '3',
      name: '板橋',
      code: 'BAC'
    }, {
      id: '4',
      name: '桃園',
      code: 'TAY',
    }, {
      id: '5',
      name: '新竹',
      code: 'HSC',
    }, {
      id: '6',
      name: '苗栗',
      code: 'MIL'
    }, {
      id: '7',
      name: '台中',
      code: 'TAC',

    }, {
      id: '8',
      name: '彰化',
      code: 'CHA'
    }, {
      id: '9',
      name: '雲林',
      code: 'YUL',
    }, {
      id: '10',
      name: '嘉義',
      code: 'CHY'
    }, {
      id: '11',
      name: '台南',
      code: 'TAN'
    }, {
      id: '12',
      name: '左營',
      code: 'ZUY'
    }
  ];

  /**
   * 已選擇的出發站
   * @type {(any | undefined)}
   * @memberof AppComponent
   */
  selectedDeparture: any | undefined;

  /**
   * 到達站
   * @type {(any[] | undefined)}
   * @memberof AppComponent
   */
  destinations: any[] = [
    {
      id: '2',
      name: '台北',
      code: 'TPE',
    }, {
      id: '3',
      name: '板橋',
      code: 'BAC'
    }, {
      id: '4',
      name: '桃園',
      code: 'TAY',
    }, {
      id: '5',
      name: '新竹',
      code: 'HSC',
    }, {
      id: '6',
      name: '苗栗',
      code: 'MIL'
    }, {
      id: '7',
      name: '台中',
      code: 'TAC',

    }, {
      id: '8',
      name: '彰化',
      code: 'CHA'
    }, {
      id: '9',
      name: '雲林',
      code: 'YUL',
    }, {
      id: '10',
      name: '嘉義',
      code: 'CHY'
    }, {
      id: '11',
      name: '台南',
      code: 'TAN'
    }, {
      id: '12',
      name: '左營',
      code: 'ZUY'
    }
  ];

  /**
   * 已選擇的到達站
   * @type {(any[] | undefined)}
   * @memberof AppComponent
   */
  selectedDestination: any[] | undefined;

  /**
   * 會員類別
   * @type {(any[] | undefined)}
   * @memberof AppComponent
   */
  memberTypes: any[] | undefined = [
    { name: '無', code: '1' },
    { name: '企業會員', code: '2' },
    { name: 'XGO', code: '3' }
  ];

  /**
   * 已選擇的會員類別
   * @type {(any | undefined)}
   * @memberof AppComponent
   */
  selectedMemberTypes: any | undefined;

  /**
   * 會員 ID
   * @type {*}
   * @memberof AppComponent
   */
  memberId: any;

  /**
   * 支付方式
   * @type {(any[] | undefined)}
   * @memberof AppComponent
   */
  paymentMethods: any[] | undefined = [
    { name: '現金', code: '1' }
  ];

  /**
   * 已選擇的支付方式
   * @type {*}
   * @memberof AppComponent
   */
  selectedPaymentMethods: any;

  /**
   * 支付金額
   * @type {*}
   * @memberof AppComponent
   */
  paymentAmt: any;


  /**
   * 旅客身份別
   * @type {any[]}
   * @memberof AppComponent
   */
  passengers: any[] = [
    {
      id: '1',
      name: '全票',
      amt: 0,
    },
    {
      id: '2',
      name: '孩童',
      amt: 0,
    },
    {
      id: '3',
      name: '敬老',
      amt: 0,
    },
    {
      id: '4',
      name: '愛心',
      amt: 0,
    },
  ];

  /**
   * 去程車次
   * @type {any[]}
   * @memberof AppComponent
   */
  outbounds: any[] = [
    {
      trainNo: '1001',
      departureTime: '2023-01-01-20:30',
      arrivalTime: '2023-01-01-20:30',
      classCode: 'Y'
    },
    {
      trainNo: '1002',
      departureTime: '2023-01-01-20:30',
      arrivalTime: '2023-01-01-20:30',
      classCode: 'Y'
    },
    {
      trainNo: '1003',
      departureTime: '2023-01-01-20:30',
      arrivalTime: '2023-01-01-20:30',
      classCode: 'Y'
    },
    {
      trainNo: '1004',
      departureTime: '2023-01-01-20:30',
      arrivalTime: '2023-01-01-20:30',
      classCode: 'Y'
    },
  ];

  /**
   * 回程車次
   * @type {any[]}
   * @memberof AppComponent
   */
  inbounds: any[] = [
    {
      trainNo: '1001',
      departureTime: '2023-01-01-20:30',
      arrivalTime: '2023-01-01-20:30',
      classCode: 'Y'
    },
    {
      trainNo: '1002',
      departureTime: '2023-01-01-20:30',
      arrivalTime: '2023-01-01-20:30',
      classCode: 'Y'
    },
    {
      trainNo: '1003',
      departureTime: '2023-01-01-20:30',
      arrivalTime: '2023-01-01-20:30',
      classCode: 'Y'
    },
    {
      trainNo: '1004',
      departureTime: '2023-01-01-20:30',
      arrivalTime: '2023-01-01-20:30',
      classCode: 'Y'
    }
  ];

  /**
   * 廂等
   * @type {any[]}
   * @memberof AppComponent
   */
  stateOptions: any[] = [
    { label: '標準', value: 'Y' },
    { label: '商務', value: 'J' }
  ];

  /**
   * 出發車次
   * @type {*}
   * @memberof AppComponent
   */
  selectedOutbound: any;

  /**
   * 回程車次
   * @type {*}
   * @memberof AppComponent
   */
  selectedInbound: any;

  /**
   * 旅客訂位代號
   * @type {*}
   * @memberof AppComponent
   */
  pnr: any;

  /**
   * 車票
   * @type {any[]}
   * @memberof AppComponent
   */
  tickets:any[]=[];

  /**
   * 今天 yyyy-MM-dd
   * @type {*}
   * @memberof AppComponent
   */
  today:any;

  /**
   * Dailog Visible
   * @type {*}
   * @memberof AppComponent
   */
  visible:any=false;

  constructor(public appService: AppService, private http: HttpClient,public datePipe: DatePipe) {
    // init version data
    this.http.get(this.appService.appConfig.masterfileURL + "/api/v1/versions").subscribe((item:any)=>{
      this.version=item.data;
    });


    // init station data
    this.http.get(this.appService.appConfig.masterfileURL + "/api/v1/stations").subscribe((item:any)=>{
      this.departures=item.data.map((departure: any) => {
        return {
          id:departure.stationId,
          name: departure.stationName,
          code: departure.stationCode,
       }
      });
      console.log(this.departures);
      this.destinations=this.departures.filter((departure:any)=>{
        return departure.id !=='1';
      });
      console.log(this.destinations);
    });
  }

  ngOnInit(): void {
    console.log("Init Web ...");
    console.log(this.appService.appConfig);
  }

  /**
   * 計算抵達站清單
   */
  createDestList() {
    this.destinations = this.departures.filter(item => this.appService.reservationRequest.departrue != item.id);
    this.appService.reservationRequest.destination = this.destinations[0].id;
  }

  /**
   * 產生表單
   */
  createForm(){
    // Free
    // this.appService.reservationRequest=this.appService.reservationRequestDefault;
    if(this.appService.reservationRequest.serviceType==='1'){
      this.appService.reservationRequest=this.appService.reservationRequestDefault;
      this.appService.reservationRequest.serviceType='1'
      this.appService.reservationRequest.outbound={}
      this.appService.reservationRequest.inbound={}
    }
    // Reserved
    if(this.appService.reservationRequest.serviceType==='2'){
      this.appService.reservationRequest=this.appService.reservationRequestDefault;
      this.appService.reservationRequest.serviceType='2';
      this.http.get(this.appService.appConfig.scheduleURL + "/api/v1/schedules").subscribe((item:any)=>{
        this.outbounds=item.data;
        this.appService.reservationRequest.outbound=this.outbounds[0];
        this.appService.reservationRequest.outbound.classCode='Y'
        this.inbounds=item.data;
        this.appService.reservationRequest.inbound=this.inbounds[0];
        this.appService.reservationRequest.inbound.classCode='Y'
      });
    }
    // Query
    if(this.appService.reservationRequest.serviceType==='3'){
     this.tickets=[];
     this.appService.ticketQueryRequest.pnr=null;
    }
  }

  /**
   * 設定預設的車廂等級
   */
  setDefaultClassCode(train:any){
    train.classCode='Y';
  }

  /*
   * 試算訂位票價
   */
  calculateReservationPrice(){
    this.http.post(this.appService.appConfig.reservationURL + "/api/v1/reservations/0/pricing",this.appService.reservationRequest).subscribe((item:any)=>{
      this.appService.reservationRequest.paymentAmt=item.data;
    })
  }

  /**
   * 訂位
   */
  reservation() {
    this.http.post(this.appService.appConfig.reservationURL + "/api/v1/reservations",this.appService.reservationRequest).subscribe((item:any)=>{
      this.appService.ticketQueryRequest.pnr= item.data;
      this.visible=true;
    })

  }

  /**
   * 查詢車票
   */
  reservationRecord() {
    // GET EXAMPLE
    this.today = this.datePipe.transform(new Date(), 'yyyy-MM-dd');
    this.http.get(this.appService.appConfig.reservationURL + "/api/v1/reservations/"+this.appService.ticketQueryRequest.pnr).subscribe((item:any)=>{
      this.tickets=item.data;
    });
  }

}
