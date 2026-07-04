package com.deepcare.dto.consultationFlow.response;

import com.deepcare.domain.consultationFlow.CrisisChecklistItem;

import java.util.List;

public record CrisisChecklistResponse(
        List<Item> items
) {
    public static CrisisChecklistResponse from(List<CrisisChecklistItem> items) {
        return new CrisisChecklistResponse(
                items.stream()
                        .map(Item::from)
                        .toList()
        );
    }

    public record Item(
            String id,
            String label,
            Boolean required,
            Boolean done
    ) {
        public static Item from(CrisisChecklistItem item) {
            return new Item(
                    item.getId(),
                    item.getLabel(),
                    item.getRequired(),
                    item.getDone()
            );
        }
    }
}
