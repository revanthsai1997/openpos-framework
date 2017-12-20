import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { DeviceService } from '../../../services/device.service';

@Component({
  selector: 'app-scan-something',
  templateUrl: './scan-something.component.html',
  styleUrls: ['./scan-something.component.scss']
})
export class ScanSomethingComponent implements OnInit {

  @Output() enter = new EventEmitter<string>();
  @Input() responseText: string;
  @Input() placeholderText: string;

  constructor(public devices: DeviceService) { }

  ngOnInit() {
  }

  public onEnter(value): void {
    this.enter.emit(value);
  }

  private filterBarcodeValue(val: string): string {
    if (!val) {
      return val;
    }
    // Filter out extra characters permitted by HTML5 input type=number (for exponentials)
    const pattern = /[e|E|\+|\-|\.]/g;

    return val.toString().replace(pattern, '');
  }

  onBarcodeKeydown(event: KeyboardEvent) {
    /*
    console.log(`[onBarcodeKeydown] key: ${event.key}`);
    console.log(`[onBarcodeKeydown] fromCharCode: ${String.fromCharCode(event.keyCode)}`);
    console.log(`[onBarcodeKeydown] keyCode: ${event.keyCode}`);
    */
    if (event.altKey || event.ctrlKey || event.metaKey ) {
      return true;
    }
    const filteredKey = this.filterBarcodeValue(event.key);
    console.log(`[onBarcodeKeydown] filtered key: ${filteredKey}`);
    return filteredKey !== null && filteredKey.length !== 0;
  }

  onBarcodePaste(event: ClipboardEvent) {
    const content = event.clipboardData.getData('text/plain');
    // console.log(`[onBarcodePaste]: ${content}`);
    const filteredContent = this.filterBarcodeValue(content);
    if (filteredContent !== content) {
      console.log(`Clipboard data contains invalid characters for barcode, suppressing pasted content '${content}'`);
    }
    return filteredContent === content;
  }
}
