import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { HomeletserverProductModule } from './product/product.module';
import { HomeletserverProductCategoryModule } from './product-category/product-category.module';
import { HomeletserverCustomerModule } from './customer/customer.module';
import { HomeletserverProductOrderModule } from './product-order/product-order.module';
import { HomeletserverOrderItemModule } from './order-item/order-item.module';
import { HomeletserverInvoiceModule } from './invoice/invoice.module';
import { HomeletserverShipmentModule } from './shipment/shipment.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        HomeletserverProductModule,
        HomeletserverProductCategoryModule,
        HomeletserverCustomerModule,
        HomeletserverProductOrderModule,
        HomeletserverOrderItemModule,
        HomeletserverInvoiceModule,
        HomeletserverShipmentModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class HomeletserverEntityModule {}
