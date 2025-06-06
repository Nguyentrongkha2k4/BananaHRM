import React from "react";
import {
  Dropdown,
  DropdownTrigger,
  DropdownMenu,
  DropdownItem,
  Button,
} from "@nextui-org/react";

interface CustomDropdownProps {
  label: string;
  options: any[];
  selectedOption: string;
  onSelectOption: (option: string) => void;
}

const CustomDropdown: React.FC<CustomDropdownProps> = ({
  label,
  options,
  selectedOption,
  onSelectOption,
}) => {
  return (
    <Dropdown className="z-30">
      <DropdownTrigger>
        <button
          className="w-full"
        >
          {selectedOption || label}
        </button>
      </DropdownTrigger>
      <DropdownMenu
        className="bg-[#1a1b23] border border-gray-300 no-scrollbar rounded w-full max-h-80 overflow-y-auto"
        aria-labelledby="dropdownMenuButton"
      >
        {options.map((option, index) => (
          <DropdownItem key={index} textValue={option} className=" dark:hover:bg-gray-500">
            <Button
              onClick={() => onSelectOption(option)}
              aria-label={option}
              className="text-center text-white w-full"
            >
              {option}
            </Button>
          </DropdownItem>
        ))}
      </DropdownMenu>
    </Dropdown>
  );
};

export default CustomDropdown;
